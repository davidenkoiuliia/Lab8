package commands;

import models.MusicBand;

import java.io.Serializable;

public class CommandDescription implements Serializable {
    protected String name; //название команды
    protected String description;  //описание команды

    protected String[] args;  //аргументы при запуске команды
    protected boolean withMusicBand = false;  //нужен ли экземпляр работника для выполнения команды
    protected MusicBand musicBand;

    protected boolean onlyUsers = true;  //команду могут выполнять только зарегистрированные пользователи


    public CommandDescription(String name, String description, boolean withMusicBand,
                              boolean onlyUsers) {
        this.name = name;
        this.description = description;
        this.withMusicBand= withMusicBand;
        this.onlyUsers = onlyUsers;
    }

    public CommandDescription(AbstractCommand command) {
        this(command.getName(), command.getDescription(), command.isWithMusicband(),
                command.isOnlyUsers());
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isWithMusicBand() {
        return withMusicBand;
    }

    public MusicBand getMusicBand() {
        return musicBand;
    }

    public boolean isOnlyUsers() {
        return onlyUsers;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public void setMusicBand(MusicBand musicBand) {
        this.musicBand = musicBand;
    }


    @Override
    public String toString() {
        return name + ": " + description;
    }


}
