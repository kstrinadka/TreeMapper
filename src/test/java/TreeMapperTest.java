import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

public class TreeMapperTest {

    private static Collection<TreeEntity> firstTreeEntity;
    private static Collection<TreeEntity> secondTreeEntity;
    private static Collection<TreeEntity> separatedNodesEntity;

    private static Collection<TreeDTO> firstTreeDTOPrepared;
    private static Collection<TreeDTO> secondTreeDTOPrepared;
    private static Collection<TreeDTO> separatedNodesDTOPrepared;

    @BeforeClass
    public static void prepareTestTreeEntity() {
        firstTreeEntity = new ArrayList<>();
        firstTreeEntity.add(new TreeEntity(1, "first", 99));
        firstTreeEntity.add(new TreeEntity(2, "second", 1));
        firstTreeEntity.add(new TreeEntity(3, "third", 1));
        firstTreeEntity.add(new TreeEntity(4, "oneSecondChild", 2));
        firstTreeEntity.add(new TreeEntity(5, "twoSecondChild", 2));

        secondTreeEntity = new ArrayList<>();
        secondTreeEntity.add(new TreeEntity(6, "hasFiveKids", 98));
        secondTreeEntity.add(new TreeEntity(7, "isFirstKid", 6));
        secondTreeEntity.add(new TreeEntity(8, "isSecondKid", 6));
        secondTreeEntity.add(new TreeEntity(9, "isThirdKid", 6));
        secondTreeEntity.add(new TreeEntity(10, "isFourthKid", 6));
        secondTreeEntity.add(new TreeEntity(11, "isFifthKid", 6));
        secondTreeEntity.add(new TreeEntity(12, "kidOne", 9));
        secondTreeEntity.add(new TreeEntity(13, "kidKidOne", 12));
        secondTreeEntity.add(new TreeEntity(14, "kidKidKidOne", 13));

        separatedNodesEntity = new ArrayList<>();
        separatedNodesEntity.add(new TreeEntity(15, "singleNodeOne", null));
        separatedNodesEntity.add(new TreeEntity(16, "singleNodeTwo", null));
        separatedNodesEntity.add(new TreeEntity(17, "singleNodeThree", null));
    }

    @BeforeClass
    public static void prepareFirstTreeDTO() {
        firstTreeDTOPrepared = new ArrayList<>();
        TreeDTO oneSecondChild = new TreeDTO(4, "oneSecondChild", new ArrayList<>());
        TreeDTO twoSecondChild = new TreeDTO(5, "twoSecondChild", new ArrayList<>());
        TreeDTO third = new TreeDTO(3, "third", new ArrayList<>());

        List<TreeDTO> tmp = new ArrayList<>();
        tmp.add(oneSecondChild);
        tmp.add(twoSecondChild);
        TreeDTO second = new TreeDTO(2, "second", tmp);

        tmp = new ArrayList<>();
        tmp.add(second);
        tmp.add(third);
        TreeDTO first = new TreeDTO(1, "first", tmp);
        firstTreeDTOPrepared.add(first);
    }

    @BeforeClass
    public static void prepareSecondTreeDTO() {
        secondTreeDTOPrepared = new ArrayList<>();
        TreeDTO kidKidKidOne = new TreeDTO(14, "kidKidKidOne", new ArrayList<>());

        List<TreeDTO> tmp = new ArrayList<>();
        tmp.add(kidKidKidOne);
        TreeDTO kidKidOne = new TreeDTO(13, "kidKidOne", tmp);

        tmp = new ArrayList<>();
        tmp.add(kidKidOne);
        TreeDTO kidOne = new TreeDTO(12, "kidOne", tmp);
        TreeDTO isFirstKid = new TreeDTO(7, "isFirstKid", new ArrayList<>());
        TreeDTO isSecondKid = new TreeDTO(8, "isSecondKid", new ArrayList<>());

        tmp = new ArrayList<>();
        tmp.add(kidOne);
        TreeDTO isThirdKid = new TreeDTO(9, "isThirdKid", tmp);
        TreeDTO isFourthKid = new TreeDTO(10, "isFourthKid", new ArrayList<>());
        TreeDTO isFifthKid = new TreeDTO(11, "isFifthKid", new ArrayList<>());

        tmp = new ArrayList<>();
        tmp.add(isFirstKid);
        tmp.add(isSecondKid);
        tmp.add(isThirdKid);
        tmp.add(isFourthKid);
        tmp.add(isFifthKid);
        TreeDTO hasFiveKids = new TreeDTO(6, "hasFiveKids", tmp);

        secondTreeDTOPrepared.add(hasFiveKids);
    }

    @BeforeClass
    public static void prepareSeparatedNodesDTO() {
        separatedNodesDTOPrepared = new ArrayList<>();
        TreeDTO singleNodeOne = new TreeDTO(15, "singleNodeOne", new ArrayList<>());
        separatedNodesDTOPrepared.add(singleNodeOne);
        TreeDTO singleNodeTwo = new TreeDTO(16, "singleNodeTwo", new ArrayList<>());
        separatedNodesDTOPrepared.add(singleNodeTwo);
        TreeDTO singleNodeThree = new TreeDTO(17, "singleNodeThree", new ArrayList<>());
        separatedNodesDTOPrepared.add(singleNodeThree);
    }

    @Test
    public void convertForFirstTree(){
        Collection<TreeDTO> firstTreeDTO = TreeMapper.convert(firstTreeEntity);
        List<TreeDTO> sortedFirstTreeDTO = firstTreeDTO.stream().sorted(new SortById()).toList();
        List<TreeDTO> sortedFirstTreeDTOPrepared = firstTreeDTOPrepared.stream().sorted(new SortById()).toList();
        Assert.assertEquals(sortedFirstTreeDTO, sortedFirstTreeDTOPrepared);
    }

    @Test
    public void convertForSecondTree(){
        Collection<TreeDTO> secondTreeDTO = TreeMapper.convert(secondTreeEntity);
        List<TreeDTO> sortedSecondTreeDTO = secondTreeDTO.stream().sorted(new SortById()).toList();
        List<TreeDTO> sortedSecondTreeDTOPreparedd = secondTreeDTOPrepared.stream().sorted(new SortById()).toList();
        Assert.assertEquals(sortedSecondTreeDTO, sortedSecondTreeDTOPreparedd);
    }

    @Test
    public void convertSeparetedNodes(){
        Collection<TreeDTO> separetedTreeDTO = TreeMapper.convert(separatedNodesEntity);
        List<TreeDTO> sortedSeparetedTreeDTO = separetedTreeDTO.stream().sorted(new SortById()).toList();
        List<TreeDTO> sortedSeparatedNodesDTOPrepared= separatedNodesDTOPrepared.stream().sorted(new SortById()).toList();
        Assert.assertEquals(sortedSeparetedTreeDTO, sortedSeparatedNodesDTOPrepared);
    }

    class SortById implements Comparator<TreeDTO>
    {
        public int compare(TreeDTO a, TreeDTO b)
        {
            return a.getId() - b.getId();
        }
    }
}
