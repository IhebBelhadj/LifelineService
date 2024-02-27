
package com.eldsync.lifelineservice.repositories;


import com.eldsync.lifelineservice.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}