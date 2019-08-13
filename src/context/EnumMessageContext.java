package context;

import constants.PipelineConstants;
import exceptions.MessageContextException;

import java.util.EnumMap;
import java.util.Map;

public class EnumMessageContext<I extends Enum<I>> implements MessageContext<I> {

    private Map<I, Object> context;

    public EnumMessageContext(Class<I> keyType) {
        context = new EnumMap<>(keyType);
    }

    @Override
    public void addItem(I key, Object item) {
        context.put(key, item);
    }

    @Override
    public Object getitem(I key, Class expectedClass) throws MessageContextException {
        Object item = context.getOrDefault(key, null);
        if (item == null) {
            throw new MessageContextException(String.format(PipelineConstants.KEYNULL, key),
                    new NullPointerException());
        }
        if (!expectedClass.isInstance(item)) {
            throw new MessageContextException(String.format(PipelineConstants.BADCONTEXT, key, expectedClass),
                    new ClassCastException());
        }
        return item;
    }

    @Override
    public void clear() {
        context.clear();
    }
}
