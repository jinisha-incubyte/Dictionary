package com.dictionary;


import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

@MicronautTest
class DictionaryControllerTest {

  @Inject
  @Client("/")
  HttpClient httpClient;

  @BeforeEach
  void setUp() {
    Dictionary dictionary = new Dictionary();
    dictionary.setWord("word1");
    dictionary = httpClient.toBlocking()
        .retrieve(HttpRequest.POST("/dictionary", dictionary), Argument.of(Dictionary.class));
    dictionary = new Dictionary();
    dictionary.setWord("word2");
    dictionary = httpClient.toBlocking()
        .retrieve(HttpRequest.POST("/dictionary", dictionary), Argument.of(Dictionary.class));
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
        .retrieve(HttpRequest.GET("/dictionary/getAllWords"), Argument.listOf(Dictionary.class));
    List<String> actualWords =
        words.stream().map(Dictionary::getWord).collect(Collectors.toList());
    List<String> expectedWords = List.of("word1","word2");
    assertThat(actualWords).containsAll(expectedWords);
  }

}
