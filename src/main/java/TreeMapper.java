import java.util.*;

public class TreeMapper {

    /**
     * @param entities - коллекция сущностей узлов из БД
     * @return - коллекция всех узлов TreDTO
     */
    public static Collection<TreeDTO> convert(Collection<TreeEntity> entities) {

        Map<Integer, TreeDTO> mapOfDTO = new HashMap<>();
        for (TreeEntity entity: entities) {
            TreeDTO currentTreeDTO = createOrGetNodeFromMap(entity, mapOfDTO);
            Integer parentId = entity.getParentId();
            if (parentId != null) {
                handleParentNode(currentTreeDTO, mapOfDTO, parentId);
            }
        }

        removeWrongNodes(mapOfDTO);

        return mapOfDTO.values();
    }

    /**
     * Добавляет в мапу узел с данным индексом, если его еще там не было. Иначе достает узел с данным индексом
     * из мапы и записывает его имя, т.к. он мог добавиться без имени на одной из предыдущих итераций.
     * @return - текущий обрабатываемый узел
     */
    private static TreeDTO createOrGetNodeFromMap(TreeEntity entity, Map<Integer, TreeDTO> mapOfDTO) {
        Integer id = entity.getId();
        String name = entity.getName();

        if (id == null || name == null) {
            throw new NullPointerException("id or name is null");
        }

        if (!mapOfDTO.containsKey(id)) {
            TreeDTO currentTreeDTO = new TreeDTO();
            currentTreeDTO.setId(id);
            currentTreeDTO.setName(name);
            currentTreeDTO.setChildren(new ArrayList<>());
            mapOfDTO.put(id, currentTreeDTO);
            return currentTreeDTO;
        }
        else {
            TreeDTO currentTreeDTO = mapOfDTO.get(id);
            currentTreeDTO.setName(name);
            return currentTreeDTO;
        }

    }

    /**
     * Добавляем текущий узел в список детей родителя.
     */
    private static void handleParentNode(TreeDTO currentTreeDTO, Map<Integer,TreeDTO> mapOfDTO, Integer parentId) {
        if (mapOfDTO.containsKey(parentId)) {
            TreeDTO parentDTO = mapOfDTO.get(parentId);
            parentDTO.getChildren().add(currentTreeDTO);
        }
        else {
            TreeDTO parentDTO = new TreeDTO();
            parentDTO.setId(parentId);
            parentDTO.setChildren(new ArrayList<>());
            parentDTO.getChildren().add(currentTreeDTO);
            mapOfDTO.put(parentId, parentDTO);
        }
    }

    /**
     * Удаление всех некорневых узлов и узлов, у которых name == null
     */
    public static void removeWrongNodes(Map<Integer, TreeDTO> map)
    {
        Set<TreeDTO> setForRemove = new HashSet<>();
        Iterator<Map.Entry<Integer, TreeDTO>> itr = map.entrySet().iterator();
        while (itr.hasNext())
        {
            Map.Entry<Integer, TreeDTO> curr = itr.next();
            if (curr.getValue().getName() == null) {
                itr.remove();
                continue;
            }

            //запоминаем детей узла, чтобы потом их удалить из результата
            List<TreeDTO> children = curr.getValue().getChildren();
            if (!children.isEmpty()) {
                setForRemove.addAll(children);
            }
        }

        for (TreeDTO node: setForRemove) {
            map.remove(node.getId());
        }
    }

}
