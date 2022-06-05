package com.dictionary;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@MicronautTest
class DictionaryControllerTest {

  @Inject
  @Client("/")
  HttpClient httpClient;

 @Inject
 DictionaryTestOnlyClient client;
  List<Words> dictionary;


//  @BeforeEach
//  void setUp() {
//    dictionary=new ArrayList<>();
//    Words word = new Words();
//    word.setWord("word1");
//    Response<Words> wordsResponse = client.save(word);
//    dictionary.add(wordsResponse.getData());
//    word=new Words();
//    word.setWord("word2");
//    wordsResponse = client.save(word);
//    dictionary.add(wordsResponse.getData());
//  }
//
//  @Test
//  void save_new_word_to_dictionary() {
//    Words actualWord = new Words();
//    actualWord.setWord("word");
//    Response<Words> expectedWord =client.save(actualWord);
//    Assertions.assertThat(actualWord.getWord().equals(expectedWord.getData()));
//  }
//
//  @Test
//  void get_all_words_from_dictionary() {
//    System.out.println(dictionary.size());
//    Response<List<Words>>  response=client.getAllWords();
//    List<String> actualWords =
//        response.getData().stream().map(Words::getWord).collect(Collectors.toList());
//    List<String> expectedWords = List.of("word1", "word2");
//    assertThat(actualWords).containsExactlyInAnyOrderElementsOf(expectedWords);
//  }
//
//
//  @Test
//  void delete_a_word_from_dictionary() {
//    Words word = new Words();
//    word.setWord("word1");
//    Response<Boolean> isWordDeleted=client.deleteWord(word);
//    assertTrue(isWordDeleted.data);
//  }
//
//  @Test
//  void update_an_existing_word_from_dictionary() {
//    Response<Boolean> isWordUpdated=client.updateWord("word1","word8");
//    assertTrue(isWordUpdated.getData());
//    Response<List<Words>>  response=client.getAllWords();
//    List<String> actualWords =
//        response.getData().stream().map(Words::getWord).collect(Collectors.toList());
//    assertFalse(actualWords.contains("word1"));
//    assertTrue(actualWords.contains("word8"));
//  }
//
//  @AfterEach
//  void clearDB() {
//
//    List<Words> words = httpClient.toBlocking()
//        .retrieve(HttpRequest.GET("/dictionary"), Argument.listOf(Words.class));
//
//    words.forEach((word) -> httpClient.toBlocking()
//        .retrieve(HttpRequest.DELETE("/dictionary", word), Argument.of(Words.class)));
//  }
}
