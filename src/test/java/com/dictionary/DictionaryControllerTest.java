package com.dictionary;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    HttpResponse<Dictionary> dictionary =
        httpClient
            .toBlocking()
            .retrieve(HttpRequest.POST("/dictionary", word1), Argument.of(HttpResponse.class));
    word2 = new Dictionary();
    word2.setWord("word2");
    HttpResponse<Dictionary> dictionary1 =
        httpClient
            .toBlocking()
            .retrieve(HttpRequest.POST("/dictionary", word2), Argument.of(HttpResponse.class));
  }

  @Test
  void save_new_word_to_dictionary() {
    Dictionary dictionary = new Dictionary();
    dictionary.setWord("word");
    dictionary =
        httpClient
            .toBlocking()
            .retrieve(HttpRequest.POST("/dictionary", dictionary), Argument.of(Dictionary.class));
    assertThat(dictionary.getWord()).isEqualTo("word");
  }

  @Test
  void get_all_words_from_dictionary() {
    List<Dictionary> words =
        httpClient
            .toBlocking()
            .retrieve(HttpRequest.GET("/dictionary"), Argument.listOf(Dictionary.class));
    List<String> actualWords = words.stream().map(Dictionary::getWord).collect(Collectors.toList());
    List<String> expectedWords = List.of("word1", "word2");
    assertThat(actualWords).containsExactlyInAnyOrderElementsOf(expectedWords);
  }

  @Test
  void delete_a_word_from_dictionary() {
    Dictionary word = new Dictionary();
    word.setWord("word1");
    Dictionary isDeleted =
        httpClient
            .toBlocking()
            .retrieve(HttpRequest.DELETE("/dictionary/" + word), Argument.of(Dictionary.class));
    List<Dictionary> words =
        httpClient
            .toBlocking()
            .retrieve(HttpRequest.GET("/dictionary"), Argument.listOf(Dictionary.class));
    List<String> actualWords = words.stream().map(Dictionary::getWord).collect(Collectors.toList());
    assertFalse(actualWords.contains("word1"));
  }

  @Test
  void update_an_existing_word_from_dictionary() {
    Dictionary word = new Dictionary();
    word.setWord("word1");
    Dictionary updatedDictionary =
        httpClient
            .toBlocking()
            .retrieve(
                HttpRequest.PUT("/dictionary/" + "word8", word), Argument.of(Dictionary.class));
    List<Dictionary> words =
        httpClient
            .toBlocking()
            .retrieve(HttpRequest.GET("/dictionary"), Argument.listOf(Dictionary.class));
    List<String> actualWords = words.stream().map(Dictionary::getWord).collect(Collectors.toList());
    assertFalse(actualWords.contains("word8"));
    assertTrue(actualWords.contains("word1"));
  }

  @AfterEach
  void clearDB() {
    List<Dictionary> words =
        httpClient
            .toBlocking()
            .retrieve(HttpRequest.GET("/dictionary"), Argument.listOf(Dictionary.class));
    words.forEach(
        (word) ->
            httpClient
                .toBlocking()
                .retrieve(
                    HttpRequest.DELETE("/dictionary/" + word), Argument.of(Dictionary.class)));
  }
}
