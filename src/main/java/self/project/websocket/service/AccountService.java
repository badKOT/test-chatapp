package self.project.websocket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import self.project.websocket.model.Account;
import self.project.websocket.repository.AccountRepository;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public void save(Account account) {
        accountRepository.save(account);
    }

    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Account with id " + id + " not found"));
    }

    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username).orElseThrow(() ->
                new NoSuchElementException("Account with username " + username + " not found"));
    }
}
