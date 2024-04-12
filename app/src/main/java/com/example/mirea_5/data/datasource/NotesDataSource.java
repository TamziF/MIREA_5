package com.example.mirea_5.data.datasource;

import com.example.mirea_5.data.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesDataSource {

    public List<Note> notes = new ArrayList<>();

    public NotesDataSource() {
        Note note1 = new Note(
                "Sport",
                "Now i know, that everyday morning work out won't become a problem, but will help in my hard gym work outs"
        );

        Note note2 = new Note(
                "Clean space",
                "Little description of your things. For example, i shall clean the space around me and in my things, to become productive and rich"
        );

        Note note3 = new Note(
                "Life is a Journey, not a Destination",
                "We should enjoy the journey of life without expecting it to ever end. Happiness and success cannot be measured by achieving certain goals, but by the experiences and joy we have along the way"
        );

        Note note4 = new Note(
                "Every Day is a New Chance for Change",
                "Our lives are constantly changing, and we must be prepared for change. Each new day gives us an opportunity to start over and do things better. It’s important to take advantage of these opportunities and not be afraid to take risks"
        );

        Note note5 = new Note(
                "Thinking is the Key to Success",
                "Our mindset determines our actions, and our actions determine our results. If we want to achieve success, we must learn to think positively and believe in ourselves"
        );

        Note note6 = new Note(
                "Friendship is a Treasure",
                "Friends are the people who support us in tough times and share our joys. Friends can be our strength and inspiration, so it’s important to appreciate and cherish friendship"
        );

        Note note7 = new Note(
                "Love is Power",
                "Love can be a powerful source of motivation and inspiration"
        );

        Note note8 = new Note(
                "You Can Always Learn More",
                "Education is a lifelong process. We must constantly learn and grow to remain competitive in today’s world"
        );

        Note note9 = new Note(
                "Happiness is a Choice",
                "Our happiness depends on how we perceive life. If we learn to see the positive, we can be happier"
        );

        Note note10 = new Note(
                "Work is Not Everything",
                "Work is important, but it should not be the only priority in life. It’s essential to find time for rest, family, and hobbies to maintain balance and harmony in life"
        );

        notes.add(note1);
        notes.add(note2);
        notes.add(note3);
        notes.add(note4);
        notes.add(note5);
        notes.add(note6);
        notes.add(note7);
        notes.add(note8);
        notes.add(note9);
        notes.add(note10);
    }
}
