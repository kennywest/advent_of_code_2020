package advent.of.code.day12;

public enum Action {
    N {
        @Override
        public void execute(Value value) {
            Map.INSTANCE.north(value);
        }

        @Override
        public void execute2(Value value) {
            Map2.INSTANCE.north(value);
        }
    },
    S {
        @Override
        public void execute(Value value) {
            Map.INSTANCE.south(value);
        }

        @Override
        public void execute2(Value value) {
            Map2.INSTANCE.south(value);
        }
    },
    E {
        @Override
        public void execute(Value value) {
            Map.INSTANCE.east(value);
        }

        @Override
        public void execute2(Value value) {
            Map2.INSTANCE.east(value);
        }
    },
    W {
        @Override
        public void execute(Value value) {
            Map.INSTANCE.west(value);
        }

        @Override
        public void execute2(Value value) {
            Map2.INSTANCE.west(value);
        }
    },
    L {
        @Override
        public void execute(Value degrees) {
            if (degrees.getValue() % 90 != 0) {
                throw new IllegalArgumentException(String.format("%s degrees not supported", degrees));
            }
            Map.INSTANCE.turnLeft(degrees);
        }

        @Override
        public void execute2(Value value) {
            Map2.INSTANCE.turnLeft(value);
        }
    },
    R {
        @Override
        public void execute(Value degrees) {
            if (degrees.getValue() % 90 != 0) {
                throw new IllegalArgumentException(String.format("%s degrees not supported", degrees));
            }
            Map.INSTANCE.turnRight(degrees);
        }

        @Override
        public void execute2(Value value) {
            Map2.INSTANCE.turnRight(value);
        }
    },
    F {
        @Override
        public void execute(Value value) {
            Map.INSTANCE.forward(value);
        }

        @Override
        public void execute2(Value value) {
            Map2.INSTANCE.forward(value);
        }
    },
    ;

    public abstract void execute(Value value);

    public abstract void execute2(Value value);
}
