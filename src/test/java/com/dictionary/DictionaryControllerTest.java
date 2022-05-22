package com.dictionary;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
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
  Dictionary word1;
  Dictionary word2;

  @BeforeEach
  void setUp() {
    word1 = new Dictionary();
    word1.setWord("word1");
    word1 = httpClient.toBlocking()
        .retrieve(HttpRequest.POST("/dictionary", word1), Argument.of(Dictionary.class));
    word2 = new Dictionary();
    word2.setWord("word2");
    word2 = httpClient.toBlocking()
        .retrieve(HttpRequest.POST("/dictionary", word2), Argument.of(Dictionary.class));
  }

  @Test
  void save_new_word() {
    Dictionary dictionary = new Dictionary();
    dictionary.setWord("word");
    dictionary = httpClient.toBlocking()
        .retrieve(HttpRequest.POST("/dictionary", dictionary), Argument.of(Dictionary.class));

    Assertions.assertThat(dictionary.getWord()).isEqualTo("word");
  }

  @Test
  void get_all_words() {

    List<Dictionary> words = httpClient.toBlocking()
        .retrieve(HttpRequest.GET("/dictionary"), Argument.listOf(Dictionary.class));
    List<String> actualWords =
        words.stream().map(Dictionary::getWord).collect(Collectors.toList());
    List<String> expectedWords = List.of("word1", "word2");
    assertThat(actualWords).containsExactlyInAnyOrderElementsOf(expectedWords);
  }


  @Test
  void delete_a_word_from_database() {
    Dictionary word = new Dictionary();
    word.setWord("word1");
    Dictionary isDeleted = httpClient.toBlocking()
        .retrieve(HttpRequest.DELETE("/dictionary", word), Argument.of(Dictionary.class));

    List<Dictionary> words = httpClient.toBlocking()
        .retrieve(HttpRequest.GET("/dictionary"), Argument.listOf(Dictionary.class));
    List<String> actualWords =
        words.stream().map(Dictionary::getWord).collect(Collectors.toList());
    assertFalse(actualWords.contains("word1"));

  }

  @AfterEach
  void clearDB() {

    List<Dictionary> words = httpClient.toBlocking()
        .retrieve(HttpRequest.GET("/dictionary"), Argument.listOf(Dictionary.class));

    words.forEach((word) -> httpClient.toBlocking()
        .retrieve(HttpRequest.DELETE("/dictionary", word), Argument.of(Dictionary.class)));

  }
}
