package uz.pdp.userregistertest.component;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.userregistertest.entity.User;
import uz.pdp.userregistertest.repository.RoleRepository;
import uz.pdp.userregistertest.repository.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {
    @Value("${spring.datasource.initialization-mode}")
    String initialMode;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")) {
            userRepository.save(new User("998009990099", passwordEncoder.encode("19301"),true,
                    roleRepository.findAll()));
        }
    }
}
