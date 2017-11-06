public interface Voenkomat {
    static Group checkForRecruits(Group g) {
        Group potentialRecruits = new Group();
        for (int i = 0; i <g.getCount() ; i++) {
            if (g.getGroup().get(i).getAge() >= 18 && g.getGroup().get(i).getSex().equals("male")){
                potentialRecruits.addToGroup(g.getGroup().get(i));
            }
        }
        return potentialRecruits;
    }
}
