package uz.pdp.userregistertest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.userregistertest.entity.Role;
import uz.pdp.userregistertest.entity.User;
import uz.pdp.userregistertest.model.Result;
import uz.pdp.userregistertest.payload.RegisterReq;
import uz.pdp.userregistertest.repository.RoleRepository;
import uz.pdp.userregistertest.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public Result saveUser(RegisterReq registerReq) {
        Result result = new Result();
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.getByName("ROLE_USER"));
        Optional<User> optional=userRepository.findByPhoneNumber(registerReq.getPhoneNumber().replace("-","")
        .replace(" ","").replace("+",""));
                System.out.println(optional.isPresent());
        if (optional.isPresent()) {
            result.setSuccess(false);
            result.setMessage("This username or email already exist");
        } else {
            String random_int = String.valueOf((Math.random() * (99999 - 10000 + 1) + 10000)).substring(0,5);
            System.out.println("random:" + random_int);
            User user=new User(registerReq.getPhoneNumber(),passwordEncoder.encode(registerReq.getPassword()),
                    random_int, roles);
            userRepository.save(user);
            result.setSuccess(true);
        }
        return result;
    }}


