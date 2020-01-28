package com.example.poc.demo.service;

import com.orbitz.consul.Consul;
import com.orbitz.consul.KeyValueClient;
import com.orbitz.consul.cache.KVCache;
//import com.orbitz.consul.model.kv.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;

@Slf4j
@Service
public class CachingConsulKVService {

    @Value("${consul.paymentsValue}")
    private Object paymentsValue;

    public CachingConsulKVService() { }

    public void testCacheConsul() {
        Consul client = Consul.builder().build();
        KeyValueClient kvClient = client.keyValueClient();

        // tell consul server to watch for new value every 30 secs
//        KVCache cache = KVCache.newCache(kvClient, "foo", 30);
//
//        cache.addListener(newValues -> {
//            Optional<Value> newValue = newValues.values().stream()
//                    .filter(value -> value.getKey().equals("foo"))
//                    .findAny();
//
//            newValue.ifPresent(value -> {
//                Optional<String> decodedValue = newValue.get().getValueAsString();
//                decodedValue.ifPresent(v -> System.out.println(String.format("New Value is: %s", v)));
//            });
//        });
//        cache.start();
    }

    public Object testJenkins() {
        return paymentsValue;
    }


//    // Cache notifies all paths with "config" as the root path
//    Optional<Value> newValue = listOfNewValues.values().stream().findAny();
//
//            newValue.ifPresent(then -> {
//        // Values are encoded in key/value store, decode it if needed
//        Optional<String> decodedValue = newValue.get().getValueAsString();
//        decodedValue.ifPresent(v -> System.out.println(String.format("Value is: %s", v)));
//    });
}
