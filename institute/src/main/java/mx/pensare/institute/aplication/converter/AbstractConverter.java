package mx.pensare.institute.aplication.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * A converter converts a source object of type {@code S} to a target of type {@code T}.
 * <p>
 * It declares {@link ModelMapper} class to make the conversion, and implent {@link Converter}.
 *
 * @author Alejandro Martin
 * @version 1.0 - 2017/05/17
 */
public abstract class AbstractConverter<S, T> implements Converter<S, T> {

    /**
     * It is used to do the mapping
     */
    protected ModelMapper modelMapper;

    /**
     * It is used for call other converters
     */
    protected ConverterService converterService;


    // setters & getters
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setConverterService(ConverterService converterService) {
        this.converterService = converterService;
    }
}
