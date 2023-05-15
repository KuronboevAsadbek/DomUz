package uz.DomUz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.DomUz.model.FileStorageModel;

public interface FileStorageRepository extends JpaRepository<FileStorageModel, Long> {
}
