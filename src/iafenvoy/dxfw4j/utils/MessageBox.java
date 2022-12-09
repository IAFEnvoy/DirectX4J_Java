package iafenvoy.dxfw4j.utils;

public class MessageBox {
    public static MessageBoxResult show(String text, String title, MessageBoxContext... contexts) {
        long type = 0;
        for (MessageBoxContext c : contexts) type |= c.getValue();
        int result = show(text, title, type);
        return MessageBoxResult.getById(result);
    }

    private static native int show(String text, String title, long type);

    public enum Buttons implements MessageBoxContext {
        Ok(0x00000000L),
        OkCancel(0x00000001L),
        AbortRetryIgnore(0x00000002L),
        YesNoCancel(0x00000003L),
        YesNo(0x00000004L),
        RetryCancel(0x00000005L),
        CancelTryContinue(0x00000006L),
        Help(0x00004000L);

        private final long value;

        Buttons(long value) {
            this.value = value;
        }

        @Override
        public long getValue() {
            return value;
        }
    }

    public enum Icon implements MessageBoxContext {
        Error(0x00000010L),
        Question(0x00000020L),
        Warning(0x00000030L),
        Information(0x00000040L);

        private final long value;

        Icon(long value) {
            this.value = value;
        }

        @Override
        public long getValue() {
            return value;
        }
    }

    public enum DefaultButton implements MessageBoxContext {
        Button1(0x00000000L),
        Button2(0x00000100L),
        Button3(0x00000200L),
        Button4(0x00000300L);

        private final long value;

        DefaultButton(long value) {
            this.value = value;
        }

        @Override
        public long getValue() {
            return value;
        }
    }

    public enum MessageBoxResult {
        Ok(1),
        Cancel(2),
        Abort(3),
        Retry(4),
        Ignore(5),
        Yes(6),
        No(7),
        TryAgain(10),
        Continue(11);

        private final int value;

        MessageBoxResult(int value) {
            this.value = value;
        }

        public static MessageBoxResult getById(int id) {
            for (MessageBoxResult result : values())
                if (result.value == id) return result;
            throw new RuntimeException("Unexpected result value");
        }
    }

    public interface MessageBoxContext {
        long getValue();
    }
}
