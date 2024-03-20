
package org.eldsync.lifelineservice2.repositories;


import org.eldsync.lifelineservice2.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}