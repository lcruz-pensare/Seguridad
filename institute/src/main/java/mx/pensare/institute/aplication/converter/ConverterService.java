package mx.pensare.institute.aplication.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionException;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Own implementation for generic converter operations. Use {@link ConversionService}
 * operations, but suit methods for project needs.
 *
 * @author Alejandro Martin
 * @version 1.0 - 2017/05/17
 * @see ConversionService
 */
@Component
public class ConverterService {

    private ConversionService conversionService;

    /**
     * Convert the given {@code source} to the specified {@code targetType}.
     * "Source object" must have a {@link
     * org.springframework.core.convert.converter.Converter converter} to "Target object",
     * since it is used the "convert method of the aforementioned".
     *
     * @param source     the source object to convert (may be {@code null})
     * @param targetType the target type to convert to (required)
     * @return the converted object, an instance of targetType
     * @throws ConversionException      if a conversion exception occurred
     * @throws IllegalArgumentException if targetType is {@code null}
     */
    public <T> T convert(Object source, Class<T> targetType) {
        return conversionService.convert(source, targetType);
    }

    /**
     * Create a new "Target object" list from the "Source object" list.
     * <p>
     * "Source object" must have a {@link
     * org.springframework.core.convert.converter.Converter converter} to "Target object",
     * since it is used the "convert method of the aforementioned".
     *
     * @param sourceList  List of source objects
     * @param sourceClass Source object class
     * @param targetClass Target object class
     * @param <T1>        Source object type
     * @param <T2>        Target object type
     * @return list with target objects
     * @throws ConversionException      if a conversion exception occurred
     * @throws IllegalArgumentException if targetType is {@code null},
     */
    @SuppressWarnings("unchecked")
    public <T1, T2> List<T2> getListOfConvertedObjects(List<T1> sourceList, Class<T1> sourceClass,
                                                       Class<T2> targetClass) {
        return (List<T2>) conversionService.convert(sourceList,
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(sourceClass)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(targetClass)));
    }

    // setters & getters

    @Autowired
    public void setConversionService(ConversionService conversionService) {
        this.conversionService = conversionService;
    }
}