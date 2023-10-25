//package org.kaczucha.service;
//
//import org.assertj.core.api.SoftAssertions;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.kaczucha.repository.entity.Client;
//import org.kaczucha.repository.InMemoryClientRepository;
//
//import java.util.*;
//
//
//public class BankServiceTest {
//    private BankService service;
//    private List<Client> clients;
//
//    @BeforeEach
//    public void setup() {
//        clients = new ArrayList<>();
//        service = new BankService(new InMemoryClientRepository(clients));
//    }
//
//    @Test
//    public void transfer_allParamsOk_fundsTransferred() {
//        //given
//        final String emailFrom = "a@a.pl";
//        final String emailTo = "b@b.pl";
//        final Client clientFrom = new Client("Alek", emailFrom, 1000);
//        final Client clientTo = new Client("Bartek", emailTo, 500);
//        clients.add(clientFrom);
//        clients.add(clientTo);
//        final double amount = 100;
//        //when
//        service.transfer(emailFrom, emailTo, amount);
//        //then
//        final Client actualFromClient = service.findByEmail(emailFrom);
//        final Client actualToClient = service.findByEmail(emailTo);
//        final Client expectedClientFrom = new Client("Alek", emailFrom, 900);
//        final Client expectedClientTo = new Client("Bartek", emailTo, 600);
//
//        SoftAssertions softAssertions = new SoftAssertions();
//        softAssertions
//                .assertThat(expectedClientFrom)
//                .isEqualTo(actualFromClient);
//        softAssertions
//                .assertThat(expectedClientTo)
//                .isEqualTo(actualToClient);
//        softAssertions.assertAll();
//
//
//    }
//
//    @Test
//    public void transfer_allFunds_fundsTransferred() {
//        //given
//        final String emailFrom = "a@a.pl";
//        final String emailTo = "b@b.pl";
//        final Client clientFrom = new Client("Alek", emailFrom, 1000);
//        final Client clientTo = new Client("Bartek", emailTo, 500);
//        clients.add(clientFrom);
//        clients.add(clientTo);
//        final double amount = 1000;
//        //when
//        service.transfer(emailFrom, emailTo, amount);
//        //then
//        final Client actualFromClient = service.findByEmail(emailFrom);
//        final Client actualToClient = service.findByEmail(emailTo);
//        final Client expectedClientFrom = new Client("Alek", emailFrom, 0);
//        final Client expectedClientTo = new Client("Bartek", emailTo, 1500);
//
//        SoftAssertions softAssertions = new SoftAssertions();
//        softAssertions
//                .assertThat(expectedClientFrom)
//                .isEqualTo(actualFromClient);
//        softAssertions
//                .assertThat(expectedClientTo)
//                .isEqualTo(actualToClient);
//        softAssertions.assertAll();
//    }
//
//    @Test
//    public void transfer_notEnoughFunds_thrownNoSufficientFundsException() {
//        //given
//        final String emailFrom = "a@a.pl";
//        final String emailTo = "b@b.pl";
//        final Client clientFrom = new Client("Alek", emailFrom, 100);
//        final Client clientTo = new Client("Bartek", emailTo, 500);
//        clients.add(clientFrom);
//        clients.add(clientTo);
//        final double amount = 1000;
//        //when/then
//        Assertions.assertThrows(
//                NoSufficientFundsException.class,
//                () -> service.transfer(emailFrom, emailTo, amount)
//        );
//
//    }
//
//
//    @Test
//    public void transfer_negativeAmount_thrownIllegalArgumentException() {
//        //given
//        final String emailFrom = "a@a.pl";
//        final String emailTo = "b@b.pl";
//        final Client clientFrom = new Client("Alek", emailFrom, 100);
//        final Client clientTo = new Client("Bartek", emailTo, 500);
//        clients.add(clientFrom);
//        clients.add(clientTo);
//        final double amount = -1000;
//        //when/then
//        Assertions.assertThrows(
//                IllegalArgumentException.class,
//                () -> service.transfer(emailFrom, emailTo, amount)
//        );
//
//    }
//
//    @Test
//    public void transfer_toSameClient_ThrownException() {
//        //given
//        final String email = "a@a.pl";
//        final Client client = new Client("Alek", email, 100);
//        clients.add(client);
//        //when/then
//        Assertions.assertThrows(
//                IllegalArgumentException.class,
//                () -> service.transfer(email,email,10)
//        );
//    }
//
//    @Test
//    public void withdraw_correctAmount_balanceChangedCorrectly(){
//        //given
//        final String email = "a@a.pl";
//        final Client client = new Client("Alek", email, 100);
//        clients.add(client);
//        //when
//        service.withdraw(email,50);
//        //then
//        Client expectedClient = new Client("Alek",email,50);
//        Assertions.assertTrue(clients.contains(expectedClient));
//    }
//    @Test
//    public void withdraw_correctFloatingPointAmount_balanceChangedCorrectly(){
//        //given
//        final String email = "a@a.pl";
//        final Client client = new Client("Alek", email, 100);
//        clients.add(client);
//        //when
//        service.withdraw(email,50.5);
//        //then
//        Client expectedClient = new Client("Alek",email,49.5);
//        clients.get(0).getBalance();
//        final Client actualClient = clients.get(0);
//        Assertions.assertEquals(expectedClient, actualClient);
//    }
//
//    @Test
//    public void withdraw_allBalance_balanceSetToZero(){
//        //given
//        final String email = "a@a.pl";
//        final Client client = new Client("Alek", email, 100);
//        clients.add(client);
//        //when
//        service.withdraw(email,100);
//        //then
//        Client expectedClient = new Client("Alek",email,0);
//        final Client actualClient = clients.get(0);
//        Assertions.assertEquals(expectedClient, actualClient);
//    }
//
//    @Test
//    public void withdraw_negativeAmount_throwsIllegalArgumentException(){
//        //given
//        final String email = "a@a.pl";
//        final Client client = new Client("Alek", email, 100);
//        clients.add(client);
//        //when
//        final int amount = -100;
//        Assertions.assertThrows(
//                IllegalArgumentException.class,
//                () -> service.withdraw(email,amount)
//        );
//    }
//
//    @Test
//    public void withdraw_zeroAmount_throwsIllegalArgumentException(){
//        //given
//        final String email = "a@a.pl";
//        final Client client = new Client("Alek", email, 100);
//        clients.add(client);
//        //when
//        final int amount = 0;
//        Assertions.assertThrows(
//                IllegalArgumentException.class,
//                () -> service.withdraw(email,amount)
//        );
//    }
//
//
//    @Test
//    public void withdraw_amountBiggerThenBalance_throwsNoSufficientFundsException(){
//        //given
//        final String email = "a@a.pl";
//        final Client client = new Client("Alek", email, 100);
//        clients.add(client);
//        //when
//        final int amount = 1000;
//        Assertions.assertThrows(
//                NoSufficientFundsException.class,
//                () -> service.withdraw(email,amount)
//        );
//    }
//
//    @Test
//    public void withdraw_incorrectEmail_throwsIlleagalArgumentException() {
//        final String email = "incorrec_email@a.pl";
//        final int amount = 100;
//        //given
//        //when/then
//        Assertions.assertThrows(
//                NoSuchElementException.class,
//                () -> service.withdraw(email, amount)
//        );
//    }
//
//    @Test
//    public void withdraw_upperCaseEmail_balanceChangedCorrectly(){
//        //given
//        final String email = "A@A.PL";
//        final Client client = new Client("Alek", "a@a.pl", 100);
//        clients.add(client);
//        //when
//        service.withdraw(email,50);
//        //then
//        Client expectedClient = new Client("Alek","a@a.pl",50);
//        final Client actualClient = clients.get(0);
//        Assertions.assertEquals(expectedClient, actualClient);
//    }
//
//    @Test
//    public void withdraw_nullEmail_throwsIllegalArgumentException() {
//        //given
//        final String email = null;
//        final int amount = 1000;
//        //when/then
//        Assertions.assertThrows(
//                IllegalArgumentException.class,
//                () -> service.withdraw(email, amount)
//        );
//    }
//
//    @Test
//    public void deleteClientFromRepository() {
//        //given
//        final String email = "a@a.pl";
//        final Client client = new Client("Alek", email, 100);
//        clients.add(client);
//        //when
//        service.deleteClient(email);
//        //then
//    }
//
//    @Test
//    public void deleteClientWithNullEmail() {
//        //given
//        final String email = null;
//        //when/then
//        Assertions.assertThrows(
//                IllegalArgumentException.class,
//                () -> service.deleteClient(email)
//        );
//    }
//
////   @Test
////    public void deleteClientWithBalanceNotZero() {
////        final String email = "a@a.pl";
////        final Client client = new Client("Alek", email, 0);
////        clients.add(client);
////        //when
////        service.deleteClient(email);
////        Assertions.assertThrows(
////                IllegalArgumentException.class,
////                () -> service.deleteClient()
////        );
////    }
//
//
//
//}
