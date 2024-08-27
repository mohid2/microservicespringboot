package app.vercel.mohammedelyousfi.user_service.presistance.repository;


import app.vercel.mohammedelyousfi.user_service.presistance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMysqlRepository extends JpaRepository<User, Long> {
}
