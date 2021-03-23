package at.activesolution.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVehicle is a Querydsl query type for Vehicle
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVehicle extends EntityPathBase<Vehicle> {

    private static final long serialVersionUID = 886215603L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVehicle vehicle = new QVehicle("vehicle");

    public final StringPath color = createString("color");

    public final StringPath fuel = createString("fuel");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath licensePlateNumber = createString("licensePlateNumber");

    public final NumberPath<Double> perform = createNumber("perform", Double.class);

    public final QPerson person;

    public final StringPath typeOfVehicle = createString("typeOfVehicle");

    public final DateTimePath<java.util.Date> yearOfManufacture = createDateTime("yearOfManufacture", java.util.Date.class);

    public QVehicle(String variable) {
        this(Vehicle.class, forVariable(variable), INITS);
    }

    public QVehicle(Path<? extends Vehicle> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVehicle(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVehicle(PathMetadata metadata, PathInits inits) {
        this(Vehicle.class, metadata, inits);
    }

    public QVehicle(Class<? extends Vehicle> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.person = inits.isInitialized("person") ? new QPerson(forProperty("person")) : null;
    }

}

