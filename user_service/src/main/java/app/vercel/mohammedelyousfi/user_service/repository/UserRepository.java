package app.vercel.mohammedelyousfi.user_service.repository;


import app.vercel.mohammedelyousfi.user_service.presistance.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
