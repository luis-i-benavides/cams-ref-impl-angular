var uglify = require('gulp-uglify'),
    cssMinify = require('gulp-minify-css'),
    sourcemaps = require('gulp-sourcemaps'),
    imagemin = require('gulp-imagemin'),
    pngquant = require('imagemin-pngquant'),
    concat = require('gulp-concat'),
    gulp = require('gulp'),
    combiner = require('stream-combiner2'),
    del = require('del'),
    livereload = require('gulp-livereload');

// Optimize application CSS files and copy to "dist" folder
gulp.task('optimize-and-copy-app-css', function() {
	var combined = combiner.obj([
		gulp.src('src/css/*.css'),
		concat('all.min.css'),
		cssMinify(),
		gulp.dest('dist/css')                      
	]);
	combined.on('error', errorHandler);
    return combined;
});
    
// Optimize library CSS files and copy to "dist" folder
gulp.task('optimize-and-copy-lib-css', function() {
    var combined = combiner.obj([
    	gulp.src([
	      'src/lib/bootstrap/dist/css/bootstrap.css',
	      'src/lib/bootstrap/dist/css/bootstrap-theme.css',
	      'src/lib/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.css'
         ]),
    	concat('all.min.css'),
        cssMinify(),
        gulp.dest('dist/lib')
	]);
	combined.on('error', errorHandler);
    return combined;
});

// Optimize application main JavaScript files and copy to "dist" folder
gulp.task('optimize-and-copy-app-js', function() {
	var combined = combiner.obj([
	    gulp.src([
		  'src/js/Main/app.js',
		  'src/js/Main/app.config.js',
		  'src/js/Main/app.router.js',
		  'src/js/Main/app.directives.js',
		  'src/js/Main/DataTableShellCtrl.js',
		  'src/js/common/transferSrv.js'
		  ]),
		concat('main.min.js'),
	    sourcemaps.init(),
	    uglify(),
	    sourcemaps.write('../Main'),
    	gulp.dest('dist/js/Main')
	]);
	combined.on('error', errorHandler);
    return combined;
});

// Optimize bower-managed JavaScript dependencies and copy to "dist" folder
gulp.task('optimize-and-copy-lib-js', function() {
	var combined = combiner.obj([
	   gulp.src([
	      'src/lib/jquery/jquery.js', 
	      'src/lib/angular/angular.js', 
	      'src/lib/angular-resource/angular-resource.js',
	      'src/lib/angular-route/angular-route.js',
	      'src/lib/angular-ui-router/release/angular-ui-router.js',
	      'src/lib/angular-cookies/angular-cookies.js',
	      'src/lib/angular-bootstrap/ui-bootstrap-tpls.js',
	      'src/lib/angular-ui-utils/ui-utils.js',
	      'src/lib/oclazyload/dist/ocLazyLoad.js',
	      'src/lib/bootstrap/dist/js/bootstrap.js',
	      'src/lib/moment/moment.js',
	      'src/lib/eonasdan-bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js'
	      ]),
      concat('all.min.js'),
      sourcemaps.init(),
      uglify(),
 	  sourcemaps.write('../lib'),
 	  gulp.dest('dist/lib')
    ]);
 	combined.on('error', errorHandler);
    return combined;
});

// Optimize images and copy to "dist" folder
gulp.task('optimize-and-copy-images', function() {
	// TO DO: Replace imagemin by another similar Gulp plugin, since it cannot be installed in Windows
	var combined = combiner.obj([
		 gulp.src('src/img/**/*'),
//		 imagemin({
//		     progressive: true,
//		     svgoPlugins: [{removeViewBox: false}],
//		     use: [pngquant()]
//		 }),
		 gulp.dest('dist/img')
     ]);
 	combined.on('error', errorHandler);
    return combined;
});

// Copy static resources to "dist" folder
gulp.task('copy-static-resources', function() {
	var combined = combiner.obj([
	   gulp.src(
		   ['src/js/**', 'src/fonts/**', 'src/partials/**'],
		   {base: 'src/'}
	   ),
	   gulp.dest('dist')                    
	]);
 	combined.on('error', errorHandler);
    return combined;
});

gulp.task('clean', function (cb) {
	  del(['dist'], cb);
});

gulp.task('build', 
		['optimize-and-copy-app-css', 'optimize-and-copy-lib-css', 
		 'optimize-and-copy-app-js', 'optimize-and-copy-lib-js', 
		 'optimize-and-copy-images', 'copy-static-resources'], 
		 function(){});

gulp.task('clean', function(cb){
	del(['dist'], cb);
});

gulp.task('default', ['clean'], function() {
    // This ensures that 'build' executes after 'clean' has finished 
	gulp.start('build');
});

gulp.task('watch', function() {
	  // Create LiveReload server
	  livereload.listen();

	  // Watch any files in dist/, reload on change
	  gulp.watch(['src/**']).on('change', livereload.changed);

});

function errorHandler (error) {
	console.log(error.toString());
	this.emit('end');
}