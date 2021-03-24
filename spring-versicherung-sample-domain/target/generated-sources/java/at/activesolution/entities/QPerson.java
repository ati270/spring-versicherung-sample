package at.activesolution.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPerson is a Querydsl query type for Person
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPerson extends EntityPathBase<Person> {

    private static final long serialVersionUID = 1104046574L;

    public static final QPerson person = new QPerson("person");

    public final StringPath address = createString("address");

    public final DateTimePath<java.util.Date> birthDate = createDateTime("birthDate", java.util.Date.class);

    public final SetPath<Contract, QContract> contracts = this.<Contract, QContract>createSet("contracts", Contract.class, QContract.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final StringPath firstname = createString("firstname");

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath identityNumber = createString("identityNumber");

    public final StringPath lastname = createString("lastname");

    public final SetPath<Vehicle, QVehicle> vehicles = this.<Vehicle, QVehicle>createSet("vehicles", Vehicle.class, QVehicle.class, PathInits.DIRECT2);

    public QPerson(String variable) {
        super(Person.class, forVariable(variable));
    }

    public QPerson(Path<? extends Person> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPerson(PathMetadata metadata) {
        super(Person.class, metadata);
    }

}

