package com.github.deogicorgi.snoopy.core.orm.service;

import com.github.deogicorgi.snoopy.core.orm.entity.UserEntity;
import com.github.deogicorgi.snoopy.core.orm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserPersistServiceImpl implements UserPersistService {

    private final UserRepository userRepository;

    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByUsernameOrEmail(String username) {
        return userRepository.findByUsernameOrEmail(username);
    }

    @Override
    public UserEntity findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    @Transactional
    public UserEntity update(UserEntity userEntity) {

        Optional<UserEntity> optional = userRepository.findById(userEntity.getId());

        if (optional.isPresent()) {
            UserEntity originEntity = optional.get();

            if (!ObjectUtils.isEmpty(userEntity.getDescription())) {
                originEntity.setDescription(userEntity.getDescription());
            }

//            if (!ObjectUtils.isEmpty(userEntity.getIsAccountExpired())) {
//                originEntity.setIsAccountExpired(userEntity.getIsAccountExpired());
//            }
//
//            if (!ObjectUtils.isEmpty(userEntity.getIsAccountLocked())) {
//                originEntity.setIsAccountLocked(userEntity.getIsAccountLocked());
//            }
//
//            if (!ObjectUtils.isEmpty(userEntity.getIsCredentialLocked())) {
//                originEntity.setIsCredentialLocked(userEntity.getIsCredentialLocked());
//            }
//
//            if (!ObjectUtils.isEmpty(userEntity.getIsEnabled())) {
//                originEntity.setIsEnabled(userEntity.getIsEnabled());
//            }

            return originEntity;
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(userRepository.findById(id).orElseThrow(() -> new RuntimeException("")));
    }
}
