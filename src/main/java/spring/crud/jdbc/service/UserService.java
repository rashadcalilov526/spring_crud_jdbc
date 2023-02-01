package spring.crud.jdbc.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.crud.jdbc.dao.entity.UserEntity;
import spring.crud.jdbc.dao.repository.UserRepository;
import spring.crud.jdbc.mapper.UserMapper;
import spring.crud.jdbc.model.dto.CreateUserDto;
import spring.crud.jdbc.model.dto.UserDto;
import spring.crud.jdbc.model.exception.NotFoundException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto getUser(Long id) {
        log.info("ActionLog.getUser.start:{}", id);

        var user = fetchUserIfExist(id);

        log.info("ActionLog.getUser.success:{}", id);
        return UserMapper.INSTANCE.mapEntityToDto(user);
    }

    public void updateUserName(Long id, String name) {
        log.info("ActionLog.updateUserName.start:{}", id);

        fetchUserIfExist(id);
        userRepository.updateUserName(name, id);

        log.info("ActionLog.updateUserName.success:{}", id);
    }

    public void createUser(CreateUserDto dto) {
        log.info("ActionLog.createUser.start");

        userRepository.insertUser(dto.getName(), dto.getAge());

        log.info("ActionLog.createUser.success");
    }

    public void deleteUser(Long id) {
        log.info("ActionLog.deleteUser.start:{}", id);

        fetchUserIfExist(id);
        userRepository.deleteUser(id);

        log.info("ActionLog.deleteUser.success:{}", id);
    }

    private UserEntity fetchUserIfExist(Long id) {
        return userRepository.getById(id).orElseThrow(() -> {
            log.error("ActionLog.fetchUserIfExist.error id:{} not found", id);
            throw new NotFoundException("USER_NOT_FOUND");
        });
    }
}
