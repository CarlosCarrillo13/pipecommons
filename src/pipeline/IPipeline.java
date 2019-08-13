package pipeline;

import constants.PipelineConstants;
import context.MessageContext;
import exceptions.MessageContextException;
import handlers.Handler;

import java.util.List;

public class IPipeline implements Pipeline {

    private List<Handler> handlers;

    @Override
    public void execute(MessageContext messageContext) throws MessageContextException {
        for (Handler handler:handlers){
            handler.execute(messageContext);
        }
    }

    public IPipeline(List<Handler> handlers) {
        if (handlers==null){
            throw new NullPointerException(PipelineConstants.NOHANDLERS);
        }
        this.handlers = handlers;
    }

    public List<Handler> getHandlers() {
        return handlers;
    }

    public void setHandlers(List<Handler> handlers) {
        this.handlers = handlers;
    }

}
