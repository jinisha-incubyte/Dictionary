package com.dictionary;


import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@MicronautTest
class DictionaryControllerTest {

  @Inject
  @Client("/")
  HttpClient httpClient;

  @Test
  void save_new_word() {
    Dictionary dictionary = new Dictionary();
    dictionary.setWord("word2");
    dictionary = httpClient.toBlocking()
        .retrieve(HttpRequest.POST("/dictionary", dictionary), Argument.of(Dictionary.class));

    Assertions.assertThat(dictionary.getWord()).isEqualTo("word2");
  }


}
