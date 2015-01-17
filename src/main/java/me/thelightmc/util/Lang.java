package me.thelightmc.util;

public enum Lang {
    NoPermission("NoPermission","&4You do not have permission to do that."),
    PlayerJoinGame("PlayerJoinGame","&6You have joined a game of &c%Game%"),
    CannotJoinGame("CannotJoinGame","&cYou can't join this game."),
    GameForceEnd("GameEnd","&4Your current game has been ended.");
    private final String path;
    private final String message;
    public enum tag {
        Game("%Game%"),Player("%p%");
        private final String value;

        tag(String value) {

            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    Lang(String path,String message) {
        this.path = path;
        this.message = message;
    }
    public String replace(String tag,String replace) {
        return message.replaceAll(tag,replace);
    }
    public String getPath() {
        return path;
    }

    public String getMessage() {
        return message;
    }
}
