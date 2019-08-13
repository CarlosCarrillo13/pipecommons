package handlers;

import context.MessageContext;
import exceptions.MessageContextException;

public interface Handler {

    void execute (MessageContext messageContext)throws MessageContextException;
}
