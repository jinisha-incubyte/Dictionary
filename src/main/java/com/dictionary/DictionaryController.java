package com.dictionary;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import java.util.List;

@Controller("/dictionary")
public class DictionaryController {

  private final DictionaryService dictionaryService;

  public DictionaryController(DictionaryService dictionaryService) {
    this.dictionaryService = dictionaryService;
  }

  @Post
  public Response<Words> save(@Body Words word) {
    Words savedWord = dictionaryService.save(word);
    return Response.success("Word Saved!", savedWord);

  }

  @Get
  public Response<List<Words>> getAllWords() {
    List<Words> words=dictionaryService.getAllWords();
    return Response.success(words);
  }

  @Delete
  //Return value is must for controller
  public Response<Boolean> deleteWord(@Body String word) {
    dictionaryService.deleteWord(word);
    return new Response(true);
  }

  @Put("/{updatedWord}")
  public Response<Boolean>  updateWord(@Body String actualWord, String updatedWord) {
    dictionaryService.updateWord(actualWord, updatedWord);
    return new Response(true);
  }
}
