package hw7.server;

import java.util.ArrayList;
import java.util.List;

public class BaseAuthService implements AuthService {

    private List<Entry> entries;

    public BaseAuthService() {
        entries = new ArrayList<>();
        entries.add(new Entry("andrew", "password", "Dron"));
        entries.add(new Entry("alice", "12345678", "Niffin"));
        entries.add(new Entry("igor", "1111", "Crazy"));
    }

    private class Entry {
        private String login;
        private String password;
        private String nick;

        public Entry(String login, String password, String nick) {
            this.login = login;
            this.password = password;
            this.nick = nick;
        }
    }

    @Override
    public void start() {
        System.out.println("Сервис авторизации запущен");
    }

    @Override
    public void stop() {
        System.out.println("Сервис авторизации остановлен");
    }

    @Override
    public String getNickByLoginAndPass(String login, String password) {
        for (Entry entry : entries) {
            if (login.equals(entry.login) && password.equals(entry.password)) {
                return entry.nick;
            }
        }
        return null;
    }
}
