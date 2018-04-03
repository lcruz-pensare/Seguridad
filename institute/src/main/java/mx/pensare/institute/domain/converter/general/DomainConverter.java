package mx.pensare.institute.domain.converter.general;

/**
 * Abstraction of a converter. It converts {@code S} to {@code S}.
 * This interface is specifically for the domain layer.
 *
 * @param <S> Source type
 * @param <T> Target type
 * @author Alejandro Martin
 * @version 1.0 - 2017/06/07
 */
public interface DomainConverter<S, T> {
    T convert(S source);
}