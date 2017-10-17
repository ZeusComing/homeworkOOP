public interface Voenkomat {
    static Group checkForRecruits(Group g) {
        Group potentialRecruits = new Group();
        for (int i = 0; i <g.getCount() ; i++) {
            if (g.getGroup()[i].getAge() >= 18 && g.getGroup()[i].getSex().equals("male")){
                potentialRecruits.addToGroup(g.getGroup()[i]);
            }
        }
        return potentialRecruits;
    }
}
