package org.kaczucha.service;

import org.junit.jupiter.api.BeforeEach;
import org.kaczucha.repository.InMemoryClientRepository;

import java.util.HashSet;

public class BankServiceTest {
    BankService service;

    @BeforeEach
    public void setup(){
        service = new BankService(new InMemoryClientRepository(new HashSet<>()));
    }

    public void test() {

    }
}
