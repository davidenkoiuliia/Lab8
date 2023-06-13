package commands;

import exceptions.NonExistentId;
import exceptions.UnavailableModelException;
import exceptions.WrongCommandArgsException;
import managers.ValidateManager;
import models.MusicBand;

import java.sql.SQLException;

public class Remove extends ServerCommand {

    public Remove() {
        super("remove_by_id", "удаляет музыкальную группу по id из коллекции",
                false, true);
    }

    @Override
    public void validateArgs(String[] args) throws NonExistentId, WrongCommandArgsException, UnavailableModelException {
        if (args.length != 1 || !ValidateManager.isInteger(args[0])) {
            throw new WrongCommandArgsException();
        }
        if (!collectionManager.existsId(Integer.parseInt(args[0]))) {
            throw new NonExistentId();
        }
        MusicBand musicBand = collectionManager.getMusicBandById(Integer.parseInt(args[0]));
        if (musicBand.getCreatorId() != user.getId()) {
            throw new UnavailableModelException();
        }
    }

    @Override
    public void execute(String[] args) {
        try {
            //удаляем в бд
            int count = MBDatabaseManager.removeMusicBand(user, collectionManager.getMusicBandById(Integer.parseInt(args[0])));
            //удаляем в коллекции
            collectionManager.remove(Integer.parseInt(args[0]));

        } catch (SQLException ignored) {
        }
    }
}
