package ru.unn.agile.dijkstra.viewModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javafx.beans.property.*;
import ru.unn.agile.dijkstra.model.Edge;
import ru.unn.agile.dijkstra.model.Graph;

import java.io.IOException;
import java.util.List;


public class ViewModel {

    private final StringProperty matrix = new SimpleStringProperty();
    private final StringProperty startVertex = new SimpleStringProperty();
    private final StringProperty finishVertex = new SimpleStringProperty();

    private final BooleanProperty calculationDisabled = new SimpleBooleanProperty();

    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();

    private final ObjectMapper mapper = new ObjectMapper();

    public ViewModel() {
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    public void calculate() {
        graphInit();
    }

    private Graph graphInit() {
        try {
            List<Edge> edges = mapper.readValue(matrix.get(),
                mapper.getTypeFactory().constructCollectionType(List.class, Edge.class));

            status.setValue(new Status(StatusType.SUCCESS).toString());

            return new Graph(edges);
        } catch (IOException e) {
            status.setValue(new Status(StatusType.BAD_FORMAT).toString());
        }
        return null;
    }

    public StringProperty matrixProperty() {
        return matrix;
    }

    public StringProperty startVertexProperty() {
        return startVertex;
    }

    public StringProperty finishVertexProperty() {
        return finishVertex;
    }

    public String getResult() {
        return result.get();
    }

    public String getStatus() {
        return status.get();
    }

    public boolean isCalculationDisabled() {
        return calculationDisabled.get();
    }
}
