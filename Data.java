// Liskov Substitution.

// With problems :
interface DataRepository {
    void persist(Object object);
    Object read(long id);
}

class CustomerRepository implements DataRepository {
    
    @Override
    public void persist(Object object) {
        System.out.println("Persist data to database.");    
    }

    @Override
    public Object read(long id) {
        return id;
    }
}


class HistoricStockPriceRepository implements DataRepository {

    // Violate Liskov Subistitution, because this class overridden persist() without need it.
    @Override
    public void persist(Object object) {
        throw new UnsupportedOperationException("Unimplemented method 'persist' (Data is read only)");
    }

    @Override
    public Object read(long id) {
        return id;
    }
}

class UIController {
    private DataRepository dataRepository;

    public void persist(Object object) {
        // there is a problem, because HistoricStockPriceRepository does not have full dependance on DataRepository, so we need to write the below condition.
        if(!(dataRepository instanceof HistoricStockPriceRepository)) {
            dataRepository.persist(object);
        }
    }

    public void retrieve(long id) {
        dataRepository.read(id);
    }
}


// The Solution : 

interface DataReadRepository {
    Object read(long id);
}

interface DataWriteRepository {
    void persist(Object object);
}


class CustomerRepository2 implements DataReadRepository, DataWriteRepository {
    
    @Override
    public void persist(Object object) {
        System.out.println("Persist data to database.");    
    }

    @Override
    public Object read(long id) {
        return id;
    }
}

class HistoricStockPriceRepository2 implements DataReadRepository {

    @Override
    public Object read(long id) {
        return id;
    }
}

class UIController2 {
    private DataReadRepository dataReadRepository;
    private DataWriteRepository dataWriteRepository;

    public void persist(Object object) {
        if(dataWriteRepository != null) {
            dataWriteRepository.persist(object);
        }
    }

    public void retrieve(long id) {
        if(dataReadRepository != null) {
            dataReadRepository.read(id);
        }
    }
}


// End Solution.