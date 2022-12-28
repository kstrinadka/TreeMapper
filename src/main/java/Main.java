import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<TreeEntity> treeEntityListExample = createTreeEntityListExample();
        List<TreeDTO> treeDTOListExample = createTreeDTOListExample();


        Collection<TreeDTO> treeDTOListReal = TreeMapper.convert(treeEntityListExample);

        for (TreeDTO dto: treeDTOListReal) {
            System.out.println(dto);
        }

    }



    private static List<TreeDTO> createTreeDTOListExample() {
        List<TreeDTO> treeDTOList = new ArrayList<>();


        TreeDTO oneSecondChild = new TreeDTO(4, "oneSecondChild", new ArrayList<>());
        treeDTOList.add(oneSecondChild);
        TreeDTO twoSecondChild = new TreeDTO(5, "twoSecondChild", new ArrayList<>());
        treeDTOList.add(twoSecondChild);
        TreeDTO third = new TreeDTO(3, "third", new ArrayList<>());
        treeDTOList.add(third);

        List<TreeDTO> tmp = new ArrayList<>();
        tmp.add(oneSecondChild);
        tmp.add(twoSecondChild);
        TreeDTO second = new TreeDTO(2, "second", tmp);
        treeDTOList.add(second);


        tmp = new ArrayList<>();
        tmp.add(second);
        tmp.add(third);
        TreeDTO first = new TreeDTO(1, "first", tmp);
        treeDTOList.add(first);

////////////////////////////////////////////////////////////////////////////////////////////////////////

        TreeDTO kidKidKidOne = new TreeDTO(14, "kidKidKidOne", new ArrayList<>());
        treeDTOList.add(kidKidKidOne);

        tmp = new ArrayList<>();
        tmp.add(kidKidKidOne);
        TreeDTO kidKidOne = new TreeDTO(13, "kidKidOne", tmp);
        treeDTOList.add(kidKidOne);

        tmp = new ArrayList<>();
        tmp.add(kidKidOne);
        TreeDTO kidOne = new TreeDTO(12, "kidOne", tmp);
        treeDTOList.add(kidOne);

        TreeDTO isFirstKid = new TreeDTO(7, "isFirstKid", new ArrayList<>());
        treeDTOList.add(isFirstKid);

        TreeDTO isSecondKid = new TreeDTO(8, "isSecondKid", new ArrayList<>());
        treeDTOList.add(isSecondKid);

        tmp = new ArrayList<>();
        tmp.add(kidOne);
        TreeDTO isThirdKid = new TreeDTO(9, "isThirdKid", tmp);
        treeDTOList.add(isThirdKid);

        TreeDTO isFourthKid = new TreeDTO(10, "isFourthKid", new ArrayList<>());
        treeDTOList.add(isFourthKid);

        TreeDTO isFifthKid = new TreeDTO(11, "isFifthKid", new ArrayList<>());
        treeDTOList.add(isFifthKid);

        tmp = new ArrayList<>();
        tmp.add(isFirstKid);
        tmp.add(isSecondKid);
        tmp.add(isThirdKid);
        tmp.add(isFourthKid);
        tmp.add(isFifthKid);
        TreeDTO hasFiveKids = new TreeDTO(6, "hasFiveKids", tmp);
        treeDTOList.add(hasFiveKids);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////

        TreeDTO singleNodeOne = new TreeDTO(15, "singleNodeOne", new ArrayList<>());
        treeDTOList.add(singleNodeOne);
        TreeDTO singleNodeTwo = new TreeDTO(16, "singleNodeTwo", new ArrayList<>());
        treeDTOList.add(singleNodeTwo);
        TreeDTO singleNodeThree = new TreeDTO(17, "singleNodeThree", new ArrayList<>());
        treeDTOList.add(singleNodeThree);

        return treeDTOList;
    }


    public static List<TreeEntity> createTreeEntityListExample() {
        List<TreeEntity> treeEntityList = new ArrayList<>();

        TreeEntity first = new TreeEntity(1, "first", 99);
        treeEntityList.add(first);
        TreeEntity second = new TreeEntity(2, "second", 1);
        treeEntityList.add(second);
        TreeEntity third = new TreeEntity(3, "third", 1);
        treeEntityList.add(third);
        TreeEntity oneSecondChild = new TreeEntity(4, "oneSecondChild", 2);
        treeEntityList.add(oneSecondChild);
        TreeEntity twoSecondChild = new TreeEntity(5, "twoSecondChild", 2);
        treeEntityList.add(twoSecondChild);

        TreeEntity hasFiveKids = new TreeEntity(6, "hasFiveKids", 98);
        treeEntityList.add(hasFiveKids);
        TreeEntity isFirstKid = new TreeEntity(7, "isFirstKid", 6);
        treeEntityList.add(isFirstKid);
        TreeEntity isSecondKid = new TreeEntity(8, "isSecondKid", 6);
        treeEntityList.add(isSecondKid);
        TreeEntity isThirdKid = new TreeEntity(9, "isThirdKid", 6);
        treeEntityList.add(isThirdKid);
        TreeEntity isFourthKid = new TreeEntity(10, "isFourthKid", 6);
        treeEntityList.add(isFourthKid);
        TreeEntity isFifthKid = new TreeEntity(11, "isFifthKid", 6);
        treeEntityList.add(isFifthKid);

        TreeEntity kidOne = new TreeEntity(12, "kidOne", 9);
        treeEntityList.add(kidOne);
        TreeEntity kidKidOne = new TreeEntity(13, "kidKidOne", 12);
        treeEntityList.add(kidKidOne);
        TreeEntity kidKidKidOne = new TreeEntity(14, "kidKidKidOne", 13);
        treeEntityList.add(kidKidKidOne);

        TreeEntity singleNodeOne = new TreeEntity(15, "singleNodeOne", null);
        treeEntityList.add(singleNodeOne);
        TreeEntity singleNodeTwo = new TreeEntity(16, "singleNodeTwo", null);
        treeEntityList.add(singleNodeTwo);
        TreeEntity singleNodeThree = new TreeEntity(17, "singleNodeThree", null);
        treeEntityList.add(singleNodeThree);

        return treeEntityList;
    }




}
