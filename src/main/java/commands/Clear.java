package commands;

import exceptions.WrongCommandArgsException;

import java.sql.SQLException;

public class Clear extends ServerCommand {
    public Clear() {
        super("clear", "очищает коллекцию", false, true);
    }

    @Override
    public void validateArgs(String[] args) throws WrongCommandArgsException {
        if (args.length != 0) {
            throw new WrongCommandArgsException();
        }
    }

    @Override
    public void execute(String[] args) {
        try {
            validateArgs(args);
            int count = MBDatabaseManager.clearMusicBand(user);
            collectionManager.clear(user.getId());
        } catch (WrongCommandArgsException | SQLException e) {
            e.printStackTrace();
        }
    }

}
