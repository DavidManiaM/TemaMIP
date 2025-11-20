package org.example.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.example.Drink;
import org.example.Food;
import org.example.Product;

import java.io.IOException;

public class ProductDeserializer extends StdDeserializer<Product> {

    public ProductDeserializer() {
        super(Product.class);
    }

    @Override
    public Product deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = p.getCodec().readTree(p);
        String name = node.get("name").asText();
        double price = node.get("price").asDouble();
        Product.Type type = Product.Type.valueOf(node.get("type").asText());
        boolean vegetarian = node.get("vegetarian").asBoolean();

        if (node.has("weight")) {
            int weight = node.get("weight").asInt();
            return new Food(name, price, weight, type, vegetarian);
        } else if (node.has("volume")) {
            int volume = node.get("volume").asInt();
            return new Drink(name, price, volume, type, vegetarian);
        }
        throw new IllegalArgumentException("Unknown product type for JSON: " + node.toString());
    }
}

