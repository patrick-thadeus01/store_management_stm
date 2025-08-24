package com.com.store_management_stm.service;

import com.com.store_management_stm.dao.ClientDao;
import com.com.store_management_stm.dto.ClientRequestDto;
import com.com.store_management_stm.dto.ClientResponseDto;
import com.com.store_management_stm.entity.ClientEntity;
import com.com.store_management_stm.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ClientServiceImpl implements ClientService{

    private ModelMapper modelMapper;
    private ClientDao clientDao;

    public ClientServiceImpl(ModelMapper modelMapper, ClientDao clientDao) {
        this.modelMapper = modelMapper;
        this.clientDao = clientDao;
    }

    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto) {
        ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
        ClientEntity clientSaved  = clientDao.save(clientEntity);
        return modelMapper.map(clientSaved, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findById(long id) {
        ClientEntity clientEntity = clientDao.findById(id).orElseThrow(()->new RuntimeException("No client found"));
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findByName(String name) {
        ClientEntity clientEntity = clientDao.findByName(name);
        return modelMapper.map(clientEntity, ClientResponseDto.class);
    }

    @Override
    public void delete(long id) {
        clientDao.deleteById(id);
    }

    @Override
    public ClientResponseDto update(long id, ClientRequestDto clientRequestDto) {
        Optional<ClientEntity> optionalClientEntity = clientDao.findById(id);
        if (!optionalClientEntity.isPresent()){
            ClientEntity clientEntity = modelMapper.map(clientRequestDto, ClientEntity.class);
            ClientEntity clientUpdate = clientDao.save(clientEntity);
            return modelMapper.map(clientEntity, ClientResponseDto.class);
        }else{
            throw new RuntimeException("Client not found");
        }
    }

    @Override
    public List<ClientResponseDto> findAll() {
        List<ClientEntity> clientEntities = clientDao.findAll();
        return clientEntities.stream().map(clientEntity -> modelMapper.map(clientEntity, ClientResponseDto.class)).collect(Collectors.toList());
    }
}
