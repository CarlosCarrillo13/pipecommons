package pipeline;

import context.MessageContext;
import exceptions.MessageContextException;

public interface Pipeline  {

    void execute(MessageContext messageContext) throws MessageContextException;
}
