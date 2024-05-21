INSERT INTO Users (id, user_name, first_name, last_name, email, password, address, date_of_registration, phone) VALUES
        (1,'JOH1379', 'Alice', 'Johnson', 'alice.johnson@email.cz', 'sysbe8-mugxIp-xafpyp', '123 Rainbow Street, Wonderland City, WC 12345, USA',null,null),
        (2, 'MIL2456', 'David', 'Miller', 'david.miller@email.cz', 'kyftys-0terRi-kuqxuf', '456 Starlight Avenue, Dreamville, DV 67890, UK',null,'123456789'),
        (3, 'KOV8912', 'Emma', 'Kovářová', 'emma.kovarova@email.cz', 'beszi0-mirxub-sufvyR', '789 Harmony Lane, Bliss Town, BT 23456, Canada',null,'666024818'),
        (4, 'JON5678', 'Michael', 'Jones', 'michael.jones@email.cz', 'mihvow-6rapba-zywbUt', '012 Tranquil Springs, TS 78901, Australia',null,null),
        (5, 'BRO1234', 'Olivia', 'Brown', 'olivia.brown@email.cz', 'zutgis-xocniX-jucni0', '455 Nirvana Village, NV 12345, Germany',null,null),
        (6, 'TAY6789', 'Ethan', 'Taylor', 'ethan.taylor@email.cz', 'gudzyr-boxty0-mafQeg', '678 Whispering Pines, SH 23456, France',null,'987654321'),
        (7, 'WHI2345', 'Sophia', 'White', 'sophia.white@email.cz', 'toswo3-rowjaF-dihqok', '901 Peaceful Meadows, PM 34567, Japan',null,null),
        (8, 'JON7890', 'Daniel', 'Johnson', 'daniel.johnson@email.cz', 'sawjus-kYsbaw-godvy3', '234 Lullaby Lane, Silent Grove, SG 45678, Brazil',null,'519305876'),
        (9, 'SMI0123', 'Isabella', 'Smith', 'isabella.smith@email.cz', 'dawqe4-qozDox-guvruw', '567 Enchanted City, EC 56789, South Africa',null,null),
        (10, 'DAV3456', 'Matthew', 'Davis', 'matthew.davis@email.cz', 'rupmot-Vacpy8-katbaj', '890 Radiant Road, Calm Corner, CC 67890, India',null,null),
        (11, 'WIL6789', 'Ava', 'Williams', 'ava.williams@email.cz', 'maRsuh-pobnag-9kyznu', '123 Melody Avenue, Harmony Haven, HH 78901, Italy',null,null),
        (12, 'BRO9012', 'Noah', 'Brown', 'noah.brown@email.cz', 'hizRew-qygcy7-vyhfiv', '456 Tranquility Lane, Elysium, EF 89012, Spain',null,'876023765'),
        (13, 'AND3456', 'Sophia', 'Anderson', 'sophia.anderson@email.cz', 'qidwi8-zIdkeq-wotdoq', ' Serenity Street, Reverie Ridge, RR 90123, Mexico',null,null),
        (14, 'TAY7890', 'Olivia', 'Taylor', 'olivia.taylor@email.cz', 'wIgmo7-foqfit-jiwdoh', '012 Zenith Road, Utopia Springs, US 01234, Sweden',null,null),
        (15, 'MOR0123', 'Benjamin', 'Morris', 'benjamin.morris@email.cz', 'nohsaW-vobne5-pivxow', '678 Velvet Lane, Dreamland, DS 23456, Switzerland',null,null);
ALTER sequence users_seq restart WITH 16;

INSERT INTO Project (id, name, description, date, condition, id_user) VALUES
        (1, 'Color Correction','Dive into the world of color correction to enhance the vibrancy and balance in your photos. Adjust hues, saturation, and brightness to achieve the perfect color palette.',CURRENT_DATE, 'I',1),
        (2, 'Crop and Resize','Precision matters. Crop and resize your images to focus on the key elements, creating a visually appealing composition that fits the project requirements.',CURRENT_DATE, 'F',10),
        (3, 'Contrast Enhancement','Elevate the drama in your photos by tweaking the contrast. Bring out details in both shadows and highlights for a more dynamic and captivating image.',CURRENT_DATE, 'I',13),
        (4, 'Background Removal','Isolate your subject by removing distracting backgrounds. Whether it is a person, object, or landscape, create a clean and professional look.',CURRENT_DATE, 'E',15),
        (5, 'Texture Overlay','Experiment with texture overlays to add depth and character to your photos. This technique can evoke different moods and enhance the overall aesthetic.',CURRENT_DATE, 'E',11),
        (6, 'Blur and Focus','Guide the viewers attention by strategically applying blur and focus effects. Highlight important elements while creating a visually pleasing background.',CURRENT_DATE, 'E',12),
        (7, 'B&W Conversion','Transform your photos into timeless classics by converting them to black and white. Explore the power of monochrome for a more dramatic impact.',CURRENT_DATE, 'F',15),
        (8, 'HDR Effect','Achieve a high dynamic range by merging multiple exposures. This technique brings out details in both shadows and highlights, creating a stunning visual impact.',CURRENT_DATE, 'F',7),
        (9, 'Vignette Application','Add a subtle vignette to draw attention to the center of the frame. This classic technique can enhance the mood and direct focus.',CURRENT_DATE, 'I',7),
        (10, 'Sharpening Details','Fine-tune your images by sharpening details. This step ensures that your photos are crisp and clear, highlighting intricate aspects.',CURRENT_DATE, 'I',14),
        (11, 'Colorization','Create a striking effect by keeping certain elements in color while desaturating the rest. This technique can emphasize specific features or unique narrative.',CURRENT_DATE, 'I',2),
        (12, 'Lens Integration','Experiment with lens flares to infuse your photos with a touch of warmth and authenticity. Carefully placed flares can add a cinematic quality.',CURRENT_DATE, 'E',7),
        (13, 'Double Exposure','Blend two images seamlessly to tell a more complex story. Double exposure techniques can create surreal and visually stunning results.',CURRENT_DATE, 'E',8),
        (14, 'Filter Application','Experiment with a variety of filters to set the mood. Whether it is a vintage vibe or a modern feel, filters can significantly alter the atmosphere of your photos.',CURRENT_DATE, 'I',1),
        (15, 'Collage Creation','Tell a visual story by combining multiple images into a cohesive collage. Arrange and layer photos to convey a narrative or theme.',CURRENT_DATE, 'F',9),
        (16, 'Reflection Effects','Introduce reflective surfaces to your photos for a unique and eye-catching twist. This can add depth and intrigue to your visuals.',CURRENT_DATE, 'F',12),
        (17, 'Panorama Stitching','Expand your horizons by stitching together panoramic images. This technique is perfect for capturing vast landscapes or detailed cityscapes.',CURRENT_DATE, 'I',4),
        (18, 'Frame Addition','Enhance the presentation of your photos by adding frames or borders. This step can provide a polished and professional finish.',CURRENT_DATE, 'F',14),
        (19, 'Blur for Backgrounds','Achieve a stunning depth of field by applying Gaussian blur to background elements. This technique is effective for portraits and product photography.',CURRENT_DATE, 'I',1),
        (20, 'Clone&Healing Brush','Remove imperfections with the clone and healing brush tools. Perfect for eliminating unwanted blemishes or distractions in your images.',CURRENT_DATE, 'E',3);
ALTER sequence project_seq restart WITH 21;

INSERT INTO Photo (id, name, description, path, date_of_upload, id_project) VALUES
        (1, 'Mountain Sunset', 'A sunset over the mountains.', '/mountain_sunset.jpg',CURRENT_DATE,14),
        (2, 'Summer Maze', 'A sunset in summertime.', '/summer_maze.jpg', CURRENT_DATE,11),
        (3, 'Floral Elegance', 'Close-up of a beautiful blooming flower.', '/floral_elegance.jpg', CURRENT_DATE,11),
        (4, 'Urban Exploration', 'Exploring the hidden corners of the city.', '/exploration.jpg', CURRENT_DATE,15),
        (5, 'Candid Laughter', 'Spontaneous laughter captured in a candid moment.', '/candid_laughter.jpg', CURRENT_DATE,7),
        (6, 'Abstract Reflections', 'Abstract reflections creating a mesmerizing pattern.', '/abstract.jpg', CURRENT_DATE,18),
        (7, 'Serenity in Nature', 'A peaceful scene in the heart of nature.', '/in_nature.jpg', CURRENT_DATE,7),
        (8, 'Vintage Memories', 'Nostalgic scene evoking memories of the past.', '/vintage.jpg', CURRENT_DATE,15),
        (9, 'Dynamic Architecture', 'Capturing the dynamic lines of modern architecture.', '/architecture.jpg', CURRENT_DATE,12),
        (10, 'Blue Sky', 'Blue blue blue sky', '/slue_sky.jpg', CURRENT_DATE,14),
        (11, 'Inquisitive Eyes', 'Close-up of a subjects curious and inquisitive eyes.', '/inquisitive.jpg', CURRENT_DATE,6),
        (12, 'Dramatic Skies', 'Stormy clouds creating a dramatic and moody atmosphere.', '/dramatic_skies.jpg', CURRENT_DATE,13),
        (13, 'Ocean Serenity', 'A tranquil scene with waves gently kissing the shore.', '/ocean_serenity.jpg', CURRENT_DATE,10),
        (14, 'Joyful Celebration', 'Moments of joy captured during a celebration.', '/celebration.jpg', CURRENT_DATE,8),
        (15, 'Metropolis Glow', 'Nighttime glow of a bustling metropolis.', '/metropolis_glow.jpg', CURRENT_DATE,6),
        (16, 'Abstract Harmony', 'Abstract composition showcasing a harmonious balance.', '/abstract.jpg', CURRENT_DATE,8),
        (17, 'Rural Tranquility', 'Peaceful scenes in the heart of the countryside.', '/tranquility.jpg', CURRENT_DATE,9),
        (18, 'Sunlit Forest', 'Golden sunlight filtering through a dense forest.', '/sunlit_forest.jpg', CURRENT_DATE,9),
        (19, 'Reflective Moments', 'Moments of introspection captured in a reflective shot.', '/moments.jpg', CURRENT_DATE,13),
        (20, 'Dynamic Waterfall', 'The power and dynamism of a cascading waterfall.', '/waterfall.jpg', CURRENT_DATE,12);
ALTER sequence photo_seq restart WITH 21;

INSERT INTO Filter (id, name, type, price, id_photo) VALUES
        (1,'MysticHaze Filter','Atmospheric',200,12),
        (2,'RetroChic Filter','Vintage',null,10),
        (3,'LuminousDream Filter','Ethereal',150,13),
        (4,'UrbanGrit Filter','Grunge',null,20),
        (5,'NatureGlow Filter','Natural',null,7),
        (6,'GalacticVibes Filter','Cosmic',null,16),
        (7,'NeonSpectra Filter','Futuristic',100,9),
        (8,'TimelessMonochrome Filter','Classic',null,15),
        (9,'AquaticBliss Filter','Underwater',350,18),
        (10,'SunsetSerene Filter','Landscape',150,19),
        (11, 'VibrantColors', 'Color', 115,17),
        (12, 'MonochromeMagic', 'Black and White', 303,11),
        (13, 'DreamyHues', 'Color', 94,8),
        (14, 'VintageCharm', 'Sepia', 126,6),
        (15, 'DynamicContrast', 'Enhancement', 202,4),
        (16, 'GlowingEdges', 'Artistic', 17,3),
        (17, 'PastelDreams', 'Color', 205,1),
        (18, 'CrispFocus', 'Sharpness', 154,5),
        (19, 'MysticalTones', 'Color', 316,14),
        (20, 'HighKeyBrightness', 'Brightness', null,2);
ALTER sequence filter_seq restart WITH 21;

INSERT INTO Category (id, name, type, data, id_photo) VALUES
        (1,'AdventureEscapes','Travel','Breathtaking landscapes from around the world.',5),
        (2,'CulinaryDelights','Food','Delectable dishes captured in various culinary settings.',20),
        (3,'WhimsicalWonders','Fantasy','Imaginative and surreal scenes invoking wonder and magic.',3),
        (4,'UrbanExploration','Cityscapes','Captivating glimpses of urban architecture and street life.',8),
        (5,'WildlifeMarvels','Nature','Stunning wildlife photography showcasing the beauty of the animal kingdom.',18),
        (6,'DynamicPortraits','People','Expressive and captivating portraits capturing diverse emotions.',12),
        (7,'AbstractAlchemy','Abstract','Intriguing and avant-garde compositions exploring form and color.',17),
        (8,'VintageVibes','Retro','Nostalgic scenes evoking the charm of bygone eras.',2),
        (9,'TechTrends','Science/Tech','Cutting-edge technology and futuristic innovations in visual form.',15),
        (10,'SeasonalSplendors','Seasons','A collection of photos highlighting the beauty of each season throughout the year.',9),
        (11,'AdventureEscapes','Travel','Breathtaking landscapes from around the world.',7),
        (12,'CulinaryDelights','Food','Delectable dishes captured in various culinary settings.',14),
        (13,'WhimsicalWonders','Fantasy','Imaginative and surreal scenes invoking wonder and magic.',1),
        (14,'UrbanExploration','Cityscapes','Captivating glimpses of urban architecture and street life.',6),
        (15,'WildlifeMarvels','Nature','Stunning wildlife photography showcasing the beauty of the animal kingdom.',11),
        (16,'UrbanExploration','Cityscapes','Captivating glimpses of urban architecture and street life.',16),
        (17,'AbstractAlchemy','Abstract','Intriguing and avant-garde compositions exploring form and color.',13),
        (18,'VintageVibes','Retro','Nostalgic scenes evoking the charm of bygone eras.',4),
        (19,'TechTrends','Science/Tech','Cutting-edge technology and futuristic innovations in visual form.',10),
        (20,'SeasonalSplendors','Seasons','A collection of photos highlighting the beauty of each season throughout the year.',19);
ALTER sequence category_seq restart WITH 21;

INSERT INTO Comment (id, text, date, id_project, parent_id_comment) VALUES
        (1,'Captivating composition! The play of light and shadow is mesmerizing.',CURRENT_DATE,11,null),
        (2,'What a stunning landscape! I can almost feel the tranquility.',CURRENT_DATE,10,null),
        (3,'The colors in this photo are so vibrant! Great job capturing the moment. ',CURRENT_DATE,19,null),
        (4,'Love the mood in this shot. It tells a story. ',CURRENT_DATE,7,null),
        (5,'Incredible macro photography! Details are on point. ',CURRENT_DATE,11,null),
        (6,'This shot is a work of art. The composition is flawless.',CURRENT_DATE,9,null),
        (7,'The simplicity here speaks volumes. Beautifully done! ',CURRENT_DATE,12,null),
        (8,'The nostalgia in this photo is heartwarming. Takes me back. ',CURRENT_DATE,19,null),
        (9,'Such a unique perspective! Love the creativity in this shot. ',CURRENT_DATE,9,null),
        (10,'Breathtaking portrait! The subjects eyes tell a compelling story. ',CURRENT_DATE,8,null),
        (11,'Fantastic use of depth of field. Draws the eye perfectly. ',CURRENT_DATE,20,null),
        (12,'This photo evokes a sense of wanderlust. Where was it taken? ',CURRENT_DATE,18,null),
        (13,'The black and white choice adds so much emotion. Timeless. ',CURRENT_DATE,10,null),
        (14,'I can almost hear the waves! Such a serene beach scene. ',CURRENT_DATE,13,null),
        (15,'The symmetry in this architectural shot is so satisfying.',CURRENT_DATE,16,null),
        (16,'Absolutely love the play of colors here. Vibrant and lively! ',CURRENT_DATE,14,null),
        (17,'This candid moment is pure joy! Smiles are contagious. ',CURRENT_DATE,12,null),
        (18,'The framing of this shot is genius. Draws you right in. ',CURRENT_DATE,15,null),
        (19,'The lighting enhances the mood beautifully. Well-captured! ',CURRENT_DATE,17,null),
        (20,'Macro magic! Natures details never cease to amaze. ',CURRENT_DATE,18,null),
        (21,'The use of negative space is so effective. Simple and powerful. ',CURRENT_DATE,17,null),
        (22,'Great storytelling through photography. I am intrigued! ',CURRENT_DATE,15,null),
        (23,'The composition in this urban shot is spot on. ',CURRENT_DATE,11,null),
        (24,'Fantastic aerial perspective! Gives a whole new view.',CURRENT_DATE,14,null),
        (25,'This photo is like poetry captured in pixels. Beautiful work',CURRENT_DATE,11,null),
        (26,'Such a serene sunset scene. Perfect way to end the day. ',CURRENT_DATE,12,5),
        (27,'This abstract shot sparks the imagination. What do you see? ',CURRENT_DATE,18,12),
        (28,'The symmetry and patterns here are oddly satisfying. Great eye! ',CURRENT_DATE,2,17),
        (29,'This close-up shot is like a burst of color therapy. Love it! ',CURRENT_DATE,9,3),
        (30,'The reflections in this photo are mind-bending. Is it a mirror?',CURRENT_DATE,17,21);
ALTER sequence comment_seq restart WITH 31;