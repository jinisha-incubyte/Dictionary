package com.dictionary;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.client.annotation.Client;
import java.util.List;

@Client("/dictionary")
public interface DictionaryTestOnlyClient {

  @Get
  Response<List<Words>> getAllWords();

  @Post
  Response<Words> save(@Body Words word);


  @Delete("/{word}")
    //Return value is must for controller
  Response<Boolean> deleteWord(String word);

  @Produces(MediaType.TEXT_PLAIN)  //Why this worked I dont know
  @Put("/{updatedWord}")
  Response<Boolean> updateWord(@Body String actualWord, String updatedWord);
}
