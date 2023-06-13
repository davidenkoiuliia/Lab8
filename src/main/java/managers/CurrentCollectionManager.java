package managers;

public class CurrentCollectionManager {

    private static CollectionManager collectionManager;

    public static CollectionManager getCollectionManager() {
        return collectionManager;
    }

    public static void setCollectionManager(CollectionManager collectionManager) {
        CurrentCollectionManager.collectionManager = collectionManager;
    }
}
