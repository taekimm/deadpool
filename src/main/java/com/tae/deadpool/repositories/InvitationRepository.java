package com.tae.deadpool.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tae.deadpool.models.Invitation;

@Repository
public interface InvitationRepository extends CrudRepository<Invitation, Long> {

}
