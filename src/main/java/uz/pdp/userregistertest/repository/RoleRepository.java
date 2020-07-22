package uz.pdp.userregistertest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.userregistertest.entity.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role getByName(String name);
}
