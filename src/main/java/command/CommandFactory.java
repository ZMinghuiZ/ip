package command;

import exception.InputException;
import tool.MessageDecoder;

public class CommandFactory {
    /**
     * This method generates the command based on the user input
     * @param input the user input
     * @return the command to be executed
     * @throws InputException if the input is invalid
     */
    public static Command generate(String input) throws InputException {
        String[] processedMessage = MessageDecoder.separateCommand(input);
        String command = processedMessage[0];
        String information = processedMessage[1];
        CommandType type = CommandType.analyseType(command);
        String[] decodedInformation = MessageDecoder.decodeInput(type, information);

        switch (type) {
        case BYE:
            return new ExitCommand();

        case LIST:
            return new ListCommand();

        case DELETE:
            return new DeleteCommand(Integer.parseInt(decodedInformation[0]));

        case MARK:
        case UNMARK:
            return new MarkUnmarkCommand(type,
                    Integer.parseInt(decodedInformation[0]));

        default:
            return new AddCommand(type, decodedInformation);
        }
    }
}
