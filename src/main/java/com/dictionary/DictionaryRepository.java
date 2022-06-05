package com.dictionary;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface DictionaryRepository extends CrudRepository<Dictionary, String> {

  @Query("update Dictionary set word= :updatedWord where word=:actualWord")
  List<String> updateWord(String updatedWord, String actualWord);
}
